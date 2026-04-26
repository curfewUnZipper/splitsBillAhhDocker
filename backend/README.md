### =========================
### BASE URL
### =========================
http://localhost:8080


### =========================
### 1. LOGIN
### =========================
POST /auth/login
Content-Type: application/json

{
  "email": "a@mail.com",
  "password": "123"
}

### Save response token manually if needed


### =========================
### 2. CREATE GROUP
### =========================
POST /groups
Content-Type: application/json

{
    "id": 2,
    "name": "Goa Trip",
    "startDate": "2026-05-01",
    "endDate": "2026-05-05",
    "status": "ACTIVE"
  }

### =========================
### 3. GET GROUPS
### =========================
GET /groups


### =========================
### 4. ADD EXPENSE (A pays)
### =========================
POST /groups/1/expenses
Content-Type: application/json

{
  "amount": 1000,
  "paidBy": "A",
  "description": "Dinner"
}


### =========================
### 5. ADD EXPENSE (B pays)
### =========================
POST /groups/1/expenses
Content-Type: application/json

{
  "amount": 500,
  "paidBy": "B",
  "description": "Taxi"
}

### =========================
### 5.1. GET EXPENSE 
### =========================

GET /groups/1/expenses

[
  {
    "createdAt": "2026-04-25T15:48:35",
    "amount": 80.0,
    "paidBy": "A",
    "description": "gg1"
  },
  {
    "createdAt": "2026-04-25T15:48:48",
    "amount": 100.0,
    "paidBy": "B",
    "description": "hh"
  }
]
### =========================
### 6. CHECK BALANCE
### =========================
GET /groups/1/balance

### Expected:
### A = 250
### B = -250


### =========================
### 7. SETTLEMENT (B pays A)
### =========================
POST /groups/1/settle
Content-Type: application/json

{
  "amount": 250,
  "paidBy": "B",
  "receivedBy": "A"
}


### =========================
### 8. CHECK BALANCE AGAIN
### =========================
GET /groups/1/balance

### Expected:
### A = 0
### B = 0


### =========================
### 9. UPDATE GROUP
### =========================
PUT /groups/1
Content-Type: application/json

{
  "name": "Goa Trip Updated"
}


### =========================
### 10. REOPEN GROUP
### =========================
POST /groups/1/reopen


### =========================
### 11. DELETE EXPENSE
### =========================
DELETE /expenses/1


### =========================
### 12. DELETE SETTLEMENT
### =========================
DELETE /settlements/1


### =========================
### 13. ADD MESSAGE
### =========================
POST /messages
Content-Type: application/json

{
  "message": "Pay your debts 😎",
  "active": true
}


### =========================
### 14. GET ALL MESSAGES
### =========================
GET /messages


### =========================
### 15. GET RANDOM MESSAGE
### =========================
GET /messages/random


### =========================
### 16. UPDATE MESSAGE
### =========================
PUT /messages/1
Content-Type: application/json

{
  "message": "Updated message",
  "active": true
}


### =========================
### 17. DELETE MESSAGE
### =========================
DELETE /messages/1


### =========================
### 18. CHANGE PASSWORD
### =========================
POST /auth/change-password
Content-Type: application/json

{
  "email": "a@mail.com",
  "newPassword": "456"
}


### =========================
### 19. FORGOT PASSWORD (SMTP)
### =========================
POST /auth/forgot-password
Content-Type: application/json

{
  "email": "a@mail.com"
}


### =========================
### 20. GET CURRENT USER
### =========================
GET /me