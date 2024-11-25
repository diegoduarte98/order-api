## Exemplos de mensagens na fila

Rabbit MQ  
http://0.0.0.0:15672

```json
{
  "id": 1,
  "customer_id": 1000,
  "status": "PENDING",
  "products": [
    {
      "id": 1,
      "name": "Cerveja AAAA",
      "quantity": 1,
      "price": "4.99"
    }
  ]
} 
```
```json
{
    "id": 1,
    "customer_id": 1000,
    "status": "PAID",
    "products": [
        {
            "id": 1,
            "name": "Cerveja AAAA",
            "quantity": 1,
            "price": "4.99"
        }
    ]
}
```
```json
{
    "id": 2,
    "customer_id": 1000,
    "status": "PENDING",
    "products": [
        {
            "id": 1,
            "name": "Cerveja xxx",
            "quantity": 2,
            "price": "4"
        },
        {
            "id": 2,
            "name": "Cerveja yyy",
            "quantity": 2,
            "price": "5"
        }
    ]
}