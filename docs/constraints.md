# Constraints

## Application

- [x] Code unique

## Role

- [x] Code unique

### Create

- [x] Parent id not null
- [x] Parent id is valid if exists in Application

### Create root

- [x] Only one root (Parent id: don't repeat a null value)

### Update

- [x] Code unique

### Delete

- [x] Check if has children
- [x] Check if has permissions

###  Move

- [ ] Parent id != Id
- [ ] Parent id not null
- [ ] Parent id exists in Application

## Permission

- [ ] Code unique

### Create

- [x] Parent id not null
- [x] Parent id is valid if exists in Application

### Update
- [x] Code unique

### Delete
- [x] Check if has children
- [x] Check if has roles

### Move

- [ ] Parent id != Id
- [ ] Parent id not null
- [ ] Parent id exists in Application