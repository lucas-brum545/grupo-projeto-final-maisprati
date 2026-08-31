import { useState } from 'react'
// import todos from '../service/todos'
import Todo from './components/Todo'
import TodoForm from './components/TodoForm'
import './App.css'
import Search from './components/Search'
import Filter from './components/Filter'

function App() {
  const [todos, setTodos] = useState([
{
    id: 1,
    text: "Criar funcionalidade x no sistema.",
    category: "Trabalho",
    isCompleted: false
},
{
    id: 2,
    text: "Ir para a academia.",
    category: "Pessoal",
    isCompleted: false
},
{
    id: 3,
    text: "Estudar react.",
    category: "Estudos",
    isCompleted: false,
}
])
  
  const [search, setSearch] = useState("")
  
  const [filter, setFilter] = useState("All")
  
  const addTodo = (text, category) =>
  {
    const newTodos = [
      ...todos,
    {
    id: Math.floor(Math.random() * 10000),
    text,
    category,
    isCompleted: false,
    },
  ]

    setTodos(newTodos)
  }

  const removeTodo = (id) => {
    const newTodos = [...todos]
    const filteredTodos = newTodos.filter(todo => todo.id !== id ? todo : null)
    setTodos(filteredTodos)
  }

  const completeTodo = (id) => {
    const newTodos = [...todos]
    newTodos.map(todo => todo.id === id ? todo.isCompleted = !todo.isCompleted : todo)
    setTodos(newTodos)
  }

  return(
    <div className="app">
      <h1>Lista de tarefas</h1>
      <Search search={search} setSearch={setSearch}></Search>
      <Filter filter={filter} setFilter={setFilter}></Filter>
      <div className='todo-list'>
      {todos
      .filter((todo) => 
        filter === "All" 
      ? true 
      : filter === "Completed" 
      ? todo.isCompleted : !todo.isCompleted)
      .filter((todo) => todo.text.toLowerCase().includes(search.toLowerCase())).map((todo) => (
        <Todo key={todo.id} todo={todo} removeTodo={removeTodo} completeTodo={completeTodo}/>
      ))}
      </div>
      <TodoForm addTodo={addTodo}/>
      
    </div>

  )
  
}

export default App
