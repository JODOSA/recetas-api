# SSL Certificates for Development

This folder contains SSL certificates used for local development.

> ⚠️ **Important:** The repository does **not** include the certificate and key files for security reasons.  
> You must generate them before starting the server.

## Generating a self-signed certificate

Run the following commands inside your project or dev machine:

```bash
openssl req -x509 -nodes -days 365 \
  -newkey rsa:2048 \
  -keyout server.key \
  -out server.crt \
  -subj
