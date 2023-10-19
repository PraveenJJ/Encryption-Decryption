function encrypt() {
    var message = document.getElementById("encryptionInput").value;
    fetch('http://localhost:8080/encryptMessage', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ message: message })
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById("encryptionResult").innerHTML = `
            <strong>Encrypted Message:</strong> ${data.encryptedMessage}<br>
            <strong>Encryption Key:</strong> ${data.key}
        `;
    })
    .catch(error => console.error('Error:', error));
}

function decrypt() {
    var encryptedMessage = document.getElementById("decryptionInput").value;
    var key = document.getElementById("decryptionKey").value;
    fetch('http://localhost:8080/decryptMessage', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ encryptedMessage: encryptedMessage, key: key })
    })
    .then(response => response.json())
    .then(data => {
        document.getElementById("decryptionResult").innerHTML = `
            <strong>Decrypted Message:</strong> ${data.decryptedMessage}
        `;
    })
    .catch(error => console.error('Error:', error));
}
