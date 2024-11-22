import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root',
})
export class CorpsService {
    private apiUrl = 'http://localhost:3001/corps';

    constructor(private http: HttpClient) {}

    getAllCorps(): Observable<any> {
        return this.http.get(this.apiUrl);
    }

    addCorps(corps: any): Observable<any> {
        return this.http.post(this.apiUrl, corps);
    }

    updateCorps(id: number, corps: any): Observable<any> {
        return this.http.put(`${this.apiUrl}/${id}`, corps);
    }

    deleteCorps(id: number): Observable<any> {
        return this.http.delete(`${this.apiUrl}/${id}`);
    }
}
