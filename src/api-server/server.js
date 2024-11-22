const express = require("express");
const fs = require("fs");
const bodyParser = require("body-parser");
const cors = require("cors");
const app = express();
const PORT = 3001;

// Enable CORS for all origins
app.use(cors()); // Corrected line

// Middleware
app.use(bodyParser.json());

// JSON File Path
const filePath = "./corps.json";

// API Endpoints

// Get All Records
// Get All Records with Pagination
app.get('/corps', (req, res) => {
  const page = parseInt(req.query.page) || 1;
  const size = parseInt(req.query.size) || 5;

  fs.readFile(filePath, 'utf8', (err, data) => {
      if (err) return res.status(500).send('Error reading data');
      const corps = JSON.parse(data);

      // Paginate results
      const startIndex = (page - 1) * size;
      const endIndex = startIndex + size;

      const paginatedData = corps.slice(startIndex, endIndex);

      res.json({
          data: paginatedData,
          total: corps.length,
      });
  });
});


// Add a new record
app.post('/corps', (req, res) => {
    const newEntry = req.body;
  
    fs.readFile(filePath, 'utf8', (err, data) => {
      if (err) return res.status(500).json({ message: 'Error reading data' });
  
      const corps = JSON.parse(data);
      // Assign a new ID (this can be more sophisticated if needed)
      newEntry.id = corps.length ? Math.max(...corps.map((d) => d.id)) + 1 : 1;
  
      corps.push(newEntry);
      fs.writeFile(filePath, JSON.stringify(corps, null, 2), (err) => {
        if (err) return res.status(500).json({ message: 'Error saving data' });
  
        res.status(201).json({ message: 'Entry added', data: newEntry }); // Return a JSON response
      });
    });
  });
  

// Update Record
app.put('/corps/:id', (req, res) => {
    const id = parseInt(req.params.id, 10);
    const updatedData = req.body;
  
    fs.readFile(filePath, 'utf8', (err, data) => {
      if (err) return res.status(500).send('Error reading data');
      const corps = JSON.parse(data);
      const index = corps.findIndex((entry) => entry.id === id);
      if (index === -1) return res.status(404).send('Entry not found');
  
      corps[index] = { ...corps[index], ...updatedData };
      fs.writeFile(filePath, JSON.stringify(corps, null, 2), (err) => {
        if (err) return res.status(500).send('Error saving data');
        res.json({ message: 'Entry updated', data: corps[index] }); // Return a JSON response
      });
    });
  });

// Delete a record
app.delete('/corps/:id', (req, res) => {
    const id = parseInt(req.params.id, 10);
  
    fs.readFile(filePath, 'utf8', (err, data) => {
      if (err) return res.status(500).json({ message: 'Error reading data' });
  
      const corps = JSON.parse(data);
      const index = corps.findIndex((entry) => entry.id === id);
      if (index === -1) return res.status(404).json({ message: 'Entry not found' });
  
      const deletedEntry = corps.splice(index, 1); // Remove the entry from the array
      fs.writeFile(filePath, JSON.stringify(corps, null, 2), (err) => {
        if (err) return res.status(500).json({ message: 'Error saving data' });
  
        res.json({ message: 'Entry deleted', data: deletedEntry[0] }); // Return a JSON response with deleted data
      });
    });
  });
  
// Start Server
app.listen(PORT, () => console.log(`API running at http://localhost:${PORT}`));
