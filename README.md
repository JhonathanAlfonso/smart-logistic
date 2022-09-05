# Smart Logistic

It's a simple API-REST that manage the orders of a logistic system. The API have the following operations:

1. Create orders, these orders are created with a unique ID and are saved ordered by order id.
2. List created orders.

## How to run

Simple run the main class `SmartLogisticApplication` and the API will be available in `http://localhost:8080`.

## How to use
### List orders
This project don't use database to save the orders, so the orders are saved in memory.
To list the orders, you can use the following command:

Endpoint: `GET api/orders`

Response:
```json
[
  {
    "id": 10,
    "customerName": "Jhonathan Salazar",
    "volume": 10,
    "price": 100
  },
  {
    "id": 20,
    "customerName": "Julian Munoz",
    "volume": 23,
    "price": 321
  },
  {
    "id": 22,
    "customerName": "Andres Penagos",
    "volume": 11,
    "price": 111
  }
]
 ```

### Save order
Endpoint: `POST api/orders`
```json
{
  "id": 11,
  "customerName": "Alfredo Vargas",
  "price": 100,
  "volume": 200
}
 ```

The order are saved ordered by id in the SortedLinkedList data structure (IdSortedOrders class).

#### Validations

The project has the following validations:

1. id must be unique and greater than cero.
2. customerName must be not null and not empty.
3. price must be greater than cero.
4. volume must be greater than cero.

