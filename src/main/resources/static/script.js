const countries = document.getElementById("countries");

let timerId;
document.getElementById("country").addEventListener("input", (event) => {
    clearTimeout(timerId);
    timerId = setTimeout(() => {
        searchCountries(event.target.value);
    }, 250);
});

function searchCountries(country) {
    fetch("http://localhost:8080/search", {
        method: "POST",
        headers: {
            "Content-Type": "application/text",
            Accept: "application/json",
        },
        body: country,
    })
        .then((response) => {
            if (response.ok) {
                response.json().then((responseJson) => {
                    clearCountries();
                    fillCountries(responseJson);
                });
            } else {
                console.error("Ошибка сервера", error);
            }
        })
        .catch((error) => {
            console.error("Ошибка запроса", error);
        });
}

function clearCountries() {
    while (countries.firstChild) {
        countries.removeChild(countries.firstChild);
    }
}

function fillCountries(responseJson) {
    responseJson.forEach((country) => {
        appendCountry(country);
    });
}

function appendCountry(country) {
    const countryItem = document.createElement("a");
    countryItem.className = "list-group-item list-group-item-action fs-5";
    countryItem.innerText = country;
    countryItem.href = "#";
    countryItem.addEventListener("click", () => {
        document.getElementById("country").value = country;
        clearCountries();
    });
    countries.appendChild(countryItem);
}
