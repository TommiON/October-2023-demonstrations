import React, { useState } from 'react'
import AddNewPerson from '../services/PersonSubmitService'

const SubmitPerson = () => {
    const [personalData, setPersonalData] = useState({
        identifier: '',
        firstname: '',
        lastname: '',
        birthplace: ''
    })

    const handleSubmit = (event) => {
        event.preventDefault()
        AddNewPerson(personalData)
    }

    const handleChange = (event) => {
        event.preventDefault()
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
                <p>Henkilötunnus</p>
                <input type='text' value={personalData.identifier} onChange={handleChange} name='identifier'/>

                <br/><br/>
                <button type='submit'>Lisää</button>
            </form>
        </div>
    )
}

export default SubmitPerson