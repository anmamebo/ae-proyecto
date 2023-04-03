/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


const addFamiliarBtn = document.getElementById('addFamiliar');
const removeFamiliarBtn = document.getElementById('removeFamiliar');
const dnisDiv = document.getElementById('dniFamiliaresInput');
const nombresDiv = document.getElementById('nombreFamiliaresInput');


addFamiliarBtn.addEventListener('click', () => {
    const dniDiv = document.createElement('div');
    dniDiv.classList.add('mb-2');
    const dniInput = document.createElement('input');
    dniInput.classList.add('form-control');
    dniInput.type = 'text';
    dniInput.name = 'dniFamiliares[]';

    const nombreDiv = document.createElement('div');
    nombreDiv.classList.add('mb-2');
    const nombreInput = document.createElement('input');
    nombreInput.classList.add('form-control');
    nombreInput.type = 'text';
    nombreInput.name = 'nombreFamiliares[]';

    dniDiv.appendChild(dniInput);
    dnisDiv.appendChild(dniDiv);
    nombreDiv.append(nombreInput);
    nombresDiv.append(nombreDiv);
});

removeFamiliarBtn.addEventListener('click', () => {    
    dnisDiv.removeChild(dnisDiv.lastChild);
    nombresDiv.removeChild(nombresDiv.lastChild);
});