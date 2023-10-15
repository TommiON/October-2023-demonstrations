import React from 'react'
import mockPOST from '../mockBackend/MockBackend'

// tänne tulisi oikeasti HTTP-pyyntöjen generointi Axiosilla/Fetchilla
const AddNewPerson = (personalData) => {
    const response = mockPOST(personalData)
    console.log('Vastaus backendista: ', response)
}

export default AddNewPerson