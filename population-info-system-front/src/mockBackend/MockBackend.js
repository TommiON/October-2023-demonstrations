import React from 'react'

// MockBackend "validoi" vain että henkilötunnus on oikean mittainen ja nimissä ei ole numeroita
// Oikeasti hyödynnettäisiin tietysti backendin palauttamia vastauksia ja HTTP-virhestatuksia

const mockPOST = (request) => {
    console.log(request)

    var errorsFound = false
    var mockHTTP400 = {
        errors: []
    }

    if (request.identifier.length !== 10) {
        mockHTTP400.errors = mockHTTP400.errors.concat('Henkilötunnus ei kelpaa')
        errorsFound = true
    }

    if (hasNumbers(request.firstname)) {
        mockHTTP400.errors = mockHTTP400.errors.concat('Etunimi ei kelpaa')
        errorsFound = true
    }

    if (hasNumbers(request.lastname)) {
        mockHTTP400.errors = mockHTTP400.errors.concat('Sukunimi ei kelpaa')
        errorsFound = true
    }

    if (errorsFound) {
        return mockHTTP400
    } else {
        return request
    }
}

const hasNumbers = (str) => {
    return /\d/.test(str);
  };

export default mockPOST