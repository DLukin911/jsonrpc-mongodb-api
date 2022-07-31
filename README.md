### Project objective

Implement a service to work with MongoDB.

### Technology stack recommended for use

Java Spring, MongoDB, Maven, GitLab CI, Docker, JSON-RPC.

### API documentation

Sending POST request ("application/json") to the address - http://localhost:8080/api

Creating Models:
```
{"jsonrpc": "2.0", "method": "create", "params": {"name": "Vanya", "comment": "Hello"}, "id": 1}
```
Update Model:
```
{"jsonrpc": "2.0", "method": "update", "params": {"id": "62e695891b8d1111bc02b3d2", "name": "Vanya2", "comment": "Hello2"}, "id": 2}
```
Delete Model:
```
{"jsonrpc": "2.0", "method": "delete", "params": {"id": "62e6962c1b8d1111bc02b3d3"}, "id": 3}
```
Get Model:
```
{"jsonrpc": "2.0", "method": "get", "params": {"id": "62e6962c1b8d1111bc02b3d3"}, "id": 4}
```
Get All Model:
```
{"jsonrpc": "2.0", "method": "getAll", "id": 5}
```