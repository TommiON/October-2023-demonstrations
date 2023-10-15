import React from 'react'
import mockPOST from '../mockBackend/MockBackend'

// tänne tulisi oikeasti HTTP-pyyntöjen generointi Axiosilla/Fetchilla
const AddNewPerson = (personalData) => {
    return mockPOST(personalData)
}

export default AddNewPerson