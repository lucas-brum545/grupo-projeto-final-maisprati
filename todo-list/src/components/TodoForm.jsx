import { useState } from "react"

export default function TodoForm({addTodo}){
    const [value, setValue] = useState("")
    const [category, setCategory] = useState("")

    const handleSubmit = (e) => {
        e.preventDefault()
        if(!value || !category) return;
        addTodo(value, category)
        // add todo
        // limpar campos
        setValue("")
        setCategory("")
    };

    return <div className="todo-form">
        <h2>Criar tarefa:</h2>
        <form onSubmit={handleSubmit}>
            <input type="text" placeholder="Digite a tarefa " value={value} onChange={(e) => setValue(e.target.value)} />
            <select value={category} onChange={(e) => setCategory(e.target.value)}>
                <option value="">Selecione uma categoria</option>
                <option value="Trabalho">Trabalho</option>
                <option value="Estudos">Estudos</option>
                <option value="Pessoal">Pessoal</option>
            </select>
            <button type="submit">Criar tarefa</button>
        </form>
    </div>
}