### Project objective

Implement a service to work with MongoDB.

### Technology stack recommended for use

Java Spring, MongoDB, Maven, GitLab CI, Docker, JSON-RPC.

### Application launch
```
docker-compose up
```

### API documentation

Sending POST request ("application/json") to the address - http://localhost:8080/api

Creating Models:
```
{"id": "1", "jsonrpc": "2.0", "method": "create", "params": {"request": {"name": "NewSolar", "comment": "New comment"}}}
```
Update Model:
```
{"id": "2", "jsonrpc": "2.0", "method": "update", "params": {"request": {"id": "62e6e143a5d1507b33d1df3a", "name": "UpdateSolar", "comment": "Update comment"}}}
```
Delete Model:
```
{"id": "3", "jsonrpc": "2.0", "method": "delete", "params": {"request": {"id": "62e6e15cc0f9951c26ea7c7a"}}}
```
Get Model:
```
{"id": "4", "jsonrpc": "2.0", "method": "get", "params": {"request": {"id": "62e6e15cc0f9951c26ea7c7a"}}}
```
Get All Model:
```
{"id": 5, "jsonrpc": "2.0", "method": "getAll"}
```