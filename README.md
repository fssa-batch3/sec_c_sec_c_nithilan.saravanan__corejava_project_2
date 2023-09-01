
# sec_c_sec_c_nithilan.saravanan__corejava_project_2

## Food Table

This table represents information about different foods available at various hotels.

| Column Name      | Data Type         | Constraints                | Description                            |
|------------------|-------------------|----------------------------|----------------------------------------|
| id               | int               | not null, auto_increment   | Unique identifier for each food entry. |
| foodname         | varchar(100)      | not null                   | Name of the food item.                 |
| hotelname        | varchar(100)      | not null                   | Name of the hotel where the food is available. |
| address          | varchar(500)      | not null                   | Address of the hotel.                  |
| foodimagelink    | varchar(100)      | not null                   | Link to an image of the food.          |
| price            | double            | not null                   | Price of the food item.                |
| rating           | double            | not null                   | Rating of the food item.               |

- **id**: Unique identifier for each food entry.
- **foodname**: Name of the food item.
- **hotelname**: Name of the hotel where the food is available.
- **address**: Address of the hotel.
- **foodimagelink**: Link to an image of the food.
- **price**: Price of the food item.
- **rating**: Rating of the food item.
