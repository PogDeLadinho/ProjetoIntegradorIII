document.addEventListener("DOMContentLoaded", function () {
    document.querySelector("form").addEventListener("submit", function (event) {
        event.preventDefault();

        const reserva = {
            nome: document.getElementById("nome").value,
            email: document.getElementById("email").value,
            dataEn: document.getElementById("dataEn").value,
            dataSai: document.getElementById("dataSai").value,
            adulto: document.getElementById("adulto").value,
            crianca: document.getElementById("crianca").value,
            observacoes: document.getElementById("observacoes").value
        };

        fetch("http://localhost:3000/reserva", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(reserva)
        })
        .then(response => response.json())
        .then(data => {
            alert("Reserva enviada com sucesso!");
            document.querySelector("form").reset();
        })
        .catch(error => {
            console.error("Erro ao enviar reserva:", error);
            alert("Erro ao enviar reserva");
        });
    });
});