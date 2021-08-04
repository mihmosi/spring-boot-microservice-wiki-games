import React, {useState} from "react";
import PropTypes from "prop-types";

function AddItem({onCreate}) {
    const [newItem, setNewItem] = useState('')

function submitHandler(event) {
    event.preventDefault()

    if (newItem.trim()) {
        onCreate(newItem)
        setNewItem('')
    }
}

    return (
        <form className="addItem_input" onSubmit={submitHandler}>
            <input value={newItem} onChange={event=> setNewItem(event.target.value)} />
            <button type="submit">Add Item</button>
        </form>
    )
}

AddItem.propTypes = {
    onCreate: PropTypes.func.isRequired
}

export default AddItem;



