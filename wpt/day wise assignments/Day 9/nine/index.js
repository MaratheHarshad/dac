const http = require("http")
const fs = require("fs")
const url = require("url")

// import user defined module which exports the users data ( username and password )
const data = require("./Users")

const users = data.users;


// create server 
const server = http.createServer((req, res) => {

    // set res header
    res.writeHead(200, { "content-type": "text/html" })

    const r = url.parse(req.url, true);

    switch (r.pathname) {

        // in case home route
        case "/":

            const rs = fs.createReadStream("./login.html")
            rs.pipe(res)
            break;

        // request to be executed based on url
        case "/submit":
            // validate the incoming data and redirect the user based on that result
            console.log(r.query.username)


            // iterate through the users array and return success if any user found with similar username and password
            const index = users.findIndex((user) => {
                return user.username === r.query.username && user.password === r.query.password;
            })

            if (index != -1) {
                res.end("success")
            } else {
                res.end("failure")
            }


            break;


    }
})


// start server
server.listen(3000, () => {
    console.log("http://localhost:3000")
})



