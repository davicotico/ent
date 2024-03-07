# Constraints

## Application
Code unique

## Role

### Create
Code unique
Parent id not null
Parent id is valid if exists in Application

### Create root
Only one root (Parent id: don't repeat a null value)

### Update
Code unique

###  Move
Parent id != Id
Parent id not null
Parent id exists in Application


## Permission

### Create
Code unique
Parent id not null
Parent id is valid if exists in Application

### Move
Parent id != Id
Parent id not null
Parent id exists in Application