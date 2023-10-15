import React, { useState } from 'react'
import AddNewPerson from '../services/PersonSubmitService'

const SubmitPerson = () => {
    const [personalData, setPersonalData] = useState({
        identifier: '',
        firstname: '',
        lastname: '',
        birthplace: ''
    })

    const [errors, setErrors] = useState({
        identifierError: '',
        firstnameError: '',
        lastnameError: '',
        birthplaceError: ''
    })

    const errorLiterals = {
        identifierError: 'Henkilötunnus ei kelpaa',
        firstnameError: 'Etunimi ei kelpaa',
        lastnameError: 'Sukunimi ei kelpaa'
    }

    console.log('Tilan virheet: ', errors)

    const handleSubmit = (event) => {
        event.preventDefault()
        
        const response = AddNewPerson(personalData)
       
        if (response.hasOwnProperty('errors')) {
            handleErrors(response)
        } else {
            setPersonalData({
                identifier: '',
                firstname: '',
                lastname: '',
                birthplace: ''
            })
        }
    }

    const handleErrors = (response) => {
        var newErrorSituation = {
            identifierError: '',
            firstnameError: '',
            lastnameError: '',
            birthplaceError: ''
        }

        response.errors.forEach(r => {
            if (r.includes('Henkilötunnus ei kelpaa')) {
                newErrorSituation.identifierError = errorLiterals.identifierError
            }
            if (r.includes('Etunimi ei kelpaa')) {
                newErrorSituation.firstnameError = errorLiterals.firstnameError
            }
            if (r.includes('Sukunimi ei kelpaa')) {
               newErrorSituation.lastnameError = errorLiterals.lastnameError
            }
        })

        setErrors(newErrorSituation)
    }

    const handleChange = (event) => {
        event.preventDefault()

        setErrors({
            identifierError: '',
            firstnameError: '',
            lastnameError: '',
            birthplaceError: ''
        })

        const field = event.target.name
        const value = event.target.value
        setPersonalData({
            ...personalData,
            [field]: value
        })
    }

    return(
        <div>
            <h2>Lisää uusi henkilö rekisteriin</h2>
            <form onSubmit={handleSubmit}>
                {errors.identifierError !=='' ? errors.identifierError : <p>Henkilötunnus</p>}
                <input type='text' value={personalData.identifier} onChange={handleChange} name='identifier'/>
               
                {errors.firstnameError !=='' ? errors.firstnameError : <p>Etunimi</p>}
                <input type='text' value={personalData.firstname} onChange={handleChange} name='firstname'/>
               
                {errors.lastnameError !=='' ? errors.lastnameError : <p>Sukunimi</p>}
                <input type='text' value={personalData.lastname} onChange={handleChange} name='lastname'/>

                <p>Syntymäpaikka</p>
                <input type='text' value={personalData.birthplace} onChange={handleChange} name='birthplace'/>

                <br/><br/>
                <button type='submit'>Lisää</button>
            </form>
        </div>
    )
}

export default SubmitPerson