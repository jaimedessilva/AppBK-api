let ul = document.querySelector('.ul');
const url = "https://app-bk.herokuapp.com/users"

const render = (listObj) =>{
    
    let html = ''
    for (v of listObj){
      html += `<br>Nome: ${v.name}</br>`  
      html += `Usuario: ${v.username}</br>`  
      html += `Senha: ${v.password}</li>`
      html += '<br>'
    }
    ul.innerHTML += html
    
}

const getApi = (() =>{
    
    list = []
    fetch(url)
        .then(res => res.json())
        .then(data =>{
            list = data
            render(list)
        })
})()
