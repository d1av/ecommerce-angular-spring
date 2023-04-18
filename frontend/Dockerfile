# Use an official Node runtime as a parent image
FROM node:18-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the Angular Universal server files to the container
COPY dist/angular-ecommerce .

# Install Nginx
RUN apk update && apk add nginx

# Copy our custom Nginx config to the container
COPY default.conf /etc/nginx/conf.d/default.conf
COPY nginx.conf /etc/nginx/nginx.conf

# Make port 4000 available for the container
EXPOSE 4000

# Start Nginx and our Angular Universal server
CMD ["nginx", "-g", "daemon off;"]
