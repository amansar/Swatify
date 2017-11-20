# Swatify

We will develop a web application that allows people to better connect through music. Users will create a profile on the site in order to rate pieces of music, post to discussion pages, follow other users, save links to songs, and receive unique music recommendations among other features. There are many programs that provide users with music recommendations that are either restricted to a certain music genre (based on what has been previously listened to) or are not tailored to the user and are based on the top charts. The best music recommendations ultimately come from others whose music taste we trust and can relate to. This application will allow users to discover a broader range of music at a deeper level than what is possible with existing music-based social networks.  

## Frontend setup

**Note: Requires having npm installed.**

Run `npm install` from `src/main/frontend`  to install dependencies, then `npm run build` to build the JavaScript files.

### Production

```sh
cd src/main/frontend
npm install
npm run build # Builds js and css to be served statically by server.
```

### Development

```sh
cd src/main/frontend
npm install
npm run start # Run a React server, watching for changes in JavaScript.
npm run watch-css # Watch for changes to *.scss files and auto-build.
```