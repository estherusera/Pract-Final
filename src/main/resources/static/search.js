async function getData(){
    let repos = [];
    const username = document.getElementById("search-bar").value;
    const url = `https://api.github.com/users/${username}/repos`;

    const response = await fetch(url);

    if (response.ok){
        const data = await response.json();

        // Se añade un elemento al final del array con .push
        data.forEach(repo => {
            let name = repo.name; 
            let full_name = repo.full_name; 
            let avatar_url = repo.owner.avatar_url;
            let html_url = repo.html_url; 

            let obj = {
                name : name,
                full_name : full_name, 
                avatar_url : avatar_url,
                html_url : html_url
            };
            
            repos.push(obj);
        })
        return repos; 
    } else {
        throw new Error("Error en la busqueda de repositorios");
    }
}

async function showData(){
    try {
        let repos = await getData();

        let max = 20;
        let index = 0;
        var html = ``;
        while (index < max){
            if (repos.length > index){
                html += `<div class=search-result><div class="left-content"><img src="${repos[index].avatar_url}"></div><div class="right-content"><p id="full-name">${repos[index].full_name}</p><a href="${repos[index].html_url}" id="name">${repos[index].name}</a></div></div>`;

            }
            index ++;
        }
        let height = 40;
        if ((15+(repos.length/2)*7) < 40){
            height = 15+(repos.length/2)*7;
        }

        //let rect = document.getElementById("title").getBoundingClientRect();
        //window.scrollTo(rect.top, rect.top);
        
        document.getElementById("search-bar-container").style.height = `${height}em`;
        setTimeout(function(){document.getElementById("search-result-container").innerHTML = html;},100);
        //document.getElementById("search-result-container").innerHTML = html;
    }catch (error){
        document.getElementById("search-bar-container").style.height = "7em";
        document.getElementById("search-result-container").innerHTML = "";
        alert(error);
    }
}