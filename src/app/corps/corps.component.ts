import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-corps',
  templateUrl: './corps.component.html',
  styleUrls: ['./corps.component.css'],
})
export class CorpsComponent implements OnInit {
  // Handles changes in age input field, make sure its set proprly
  handleAgeInputChange(event: any): void {
    const input = event.target?.value;
    this.newLimiteAge = input !== '' ? parseInt(input, 10) : null;

    // For debuging purpose only, show input value
    console.log('Age input changed to:', this.newLimiteAge);
  }

  corpsData: any[] = [];
  displayedColumns: string[] = ['id', 'code', 'designation', 'limite_age', 'actions'];

  // For new row form data (defults set here)
  newCode: string = '';
  newDesignation: string = '';
  newLimiteAge: number | null = null; // Set as empty initally 

  // For pagintion setup and keeping track of current pg
  currentPage: number = 1;
  totalRows: number = 0;
  pageSize: number = 5;
  totalPages: number = 0;

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.fetchCorps(this.currentPage, this.pageSize); // fetch corps data when comp loads
  }

  // fetches corps from the server with paging
  fetchCorps(page: number, size: number): void {
    this.http
      .get<any>(`http://localhost:3001/corps?page=${page}&size=${size}`)
      .subscribe(
        (response) => {
          this.corpsData = response.data;
          this.totalRows = response.total; // total no of rows
          this.totalPages = Math.ceil(this.totalRows / this.pageSize); // clac total pgs
        },
        (error) => {
          console.error('Error fetching data:', error); // log fetch err if faild
        }
      );
  }

  // Adds a new row if form is valid, else shows err msg
  addRow(form: any): void {
    if (!this.newCode.trim() || !this.newDesignation.trim() || this.newLimiteAge === null) {
      let missingFields = [];
      if (!this.newCode.trim()) missingFields.push('Code');
      if (!this.newDesignation.trim()) missingFields.push('Designation');
      if (this.newLimiteAge === null) missingFields.push("Limite d'âge");

      // Alerts user to fill all field required
      Swal.fire({
        icon: 'error',
        title: 'Champs requis manquants',
        text: `Veuillez remplir les champs suivants: ${missingFields.join(', ')}`,
      });
      return;
    }

    const newEntry = {
      code: this.newCode.trim(),
      designation: this.newDesignation.trim(),
      limite_age: this.newLimiteAge,
    };

    this.http.post('http://localhost:3001/corps', newEntry).subscribe(
      () => {
        this.fetchCorps(this.currentPage, this.pageSize);
        this.newCode = '';
        this.newDesignation = '';
        this.newLimiteAge = null; // Cleared form vals
        form.resetForm(); // Reste the form visually

        Swal.fire('Succès', 'Nouveau corps ajouté', 'success'); // Notify for add success
      },
      (error) => {
        console.error('Error adding data:', error);
        Swal.fire('Erreur', 'Une erreur est survenue. Veuillez réessayer.', 'error');
      }
    );
  }

  // Update an existing row using input
  editRow(row: any): void {
    Swal.fire({
      title: 'Modifier le Corps',
      html: `
        <div>
          <label for="code">Code:</label>
          <input id="code" class="swal2-input" value="${row.code}" />
        </div>
        <div>
          <label for="designation">Désignation:</label>
          <input id="designation" class="swal2-input" value="${row.designation}" />
        </div>
        <div>
          <label for="limite_age">Limite d'âge:</label>
          <input id="limite_age" class="swal2-input" type="number" value="${row.limite_age || ''}" />
        </div>
      `,
      showCancelButton: true,
      confirmButtonText: 'Mettre à jour',
      cancelButtonText: 'Annuler',
    }).then((result) => {
      if (result.isConfirmed) {
        // Retrieve updated values from inputs
        const code = (document.getElementById('code') as HTMLInputElement).value.trim();
        const designation = (document.getElementById('designation') as HTMLInputElement).value.trim();
        const limiteAgeInput = (document.getElementById('limite_age') as HTMLInputElement).value.trim();
        const limiteAge = limiteAgeInput ? parseInt(limiteAgeInput, 10) : null;
  
        // Input validation
        const missingFields = [];
        if (!code) missingFields.push('Code');
        if (!designation) missingFields.push('Désignation');
        if (limiteAge === null || isNaN(limiteAge)) missingFields.push("Limite d'âge");
  
        if (missingFields.length > 0) {
          Swal.fire({
            icon: 'error',
            title: 'Champs requis manquants',
            text: `Veuillez remplir les champs suivants: ${missingFields.join(', ')}`,
          });
          return;
        }
  
        // Check for SQL Injection or XSS in input
        const forbiddenPatterns = /[<>;'"]|--|\/\*|\*\/|#|DROP|SELECT|INSERT|DELETE|UPDATE|SCRIPT/gi;
        if (
          forbiddenPatterns.test(code) ||
          forbiddenPatterns.test(designation) ||
          forbiddenPatterns.test(limiteAgeInput)
        ) {
          Swal.fire({
            icon: 'error',
            title: 'Entrée invalide',
            text: "Les champs contiennent des caractères ou des mots-clés interdits (par exemple, code SQL ou script).",
          });
          return;
        }
  
        const updatedRow = { ...row, code, designation, limite_age: limiteAge };
  
        // Send update request
        this.http.put(`http://localhost:3001/corps/${row.id}`, updatedRow).subscribe(
          () => {
            this.fetchCorps(this.currentPage, this.pageSize); // Refresh the table
            Swal.fire('Succès', 'Corps mis à jour', 'success'); // Success notification
          },
          (error) => {
            console.error('Error updating data:', error);
            Swal.fire('Erreur', 'Impossible de mettre à jour', 'error'); // Failure notification
          }
        );
      }
    });
  }
  

  // Delete entry after user confirm
  deleteRow(row: any): void {
    Swal.fire({
      title: 'Êtes-vous sûr?',
      text: 'Voulez-vous supprimer ce corps?',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Oui, supprimer',
      cancelButtonText: 'Annuler',
    }).then((result) => {
      if (result.isConfirmed) {
        this.http.delete(`http://localhost:3001/corps/${row.id}`).subscribe(
          () => {
            this.fetchCorps(this.currentPage, this.pageSize); // update view
            setTimeout(() => {
              if (this.corpsData.length === 0 && this.currentPage > 1) {
                this.currentPage--;
                this.fetchCorps(this.currentPage, this.pageSize);
              }
            }, 100); // Dealy added to fix page switch issues
            Swal.fire('Supprimé', 'Le corps a été supprimé', 'success'); // Notify delete
          },
          (error) => {
            console.error('Error deleting data:', error);
            Swal.fire('Erreur', 'Impossible de supprimer', 'error'); // On del fail show msg
          }
        );
      }
    });
  }

  // Handles page change (prev/nex)
  changePage(direction: string): void {
    if (direction === 'next' && this.currentPage < this.totalPages) {
      this.currentPage++;
      this.fetchCorps(this.currentPage, this.pageSize); // Fetch next
    } else if (direction === 'prev' && this.currentPage > 1) {
      this.currentPage--;
      this.fetchCorps(this.currentPage, this.pageSize); // fetch previuos
    }
  }
}
