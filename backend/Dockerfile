# Dockerfile for React frontend

# Build react frontend
FROM node:15.5.0

# Working directory be app
WORKDIR /app

# Copy package.json and package-lock.json (if applicable) to the container
COPY package*.json ./

###  Installing dependencies
RUN npm install

# copy local files to app folder
COPY . .

EXPOSE 3000

CMD ["npm","start"]