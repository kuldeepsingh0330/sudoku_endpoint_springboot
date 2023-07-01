# sudoku_endpoint_springboot

This is a Sudoku Solver API built using Spring Boot. It provides endpoints to interact with a Sudoku board and solve it.

## Features

- Reset the Sudoku game and start a fresh game.
- Insert valid numbers into the Sudoku board and validate the moves.
- Get a suggested move after three consecutive invalid responses.
- Solve the Sudoku board and retrieve the solved result.

## Technologies Used

- Java
- Spring Boot
- Maven


The application will start running on `http://localhost:8080`.

## API Endpoints

- `POST /sudoku/start`: Start a new Sudoku game and reset the board.
- `POST /sudoku/move`: Make a move by providing the row and column of the Sudoku board and the number to insert.

## Usage

You can use tools like Postman to interact with the Sudoku Solver API. Refer to the API endpoints section for detailed information on each endpoint and their usage.

## Screeshot
<img src="https://github.com/kuldeepsingh0330/sudoku_endpoint_springboot/assets/95225751/2e87da03-a84a-486b-ac23-81905c4a07c9" alt="Image_start" width="800" height="400" />
<img src="https://github.com/kuldeepsingh0330/sudoku_endpoint_springboot/assets/95225751/7ce44281-aeef-4266-9ee4-c6aad4833fc3
" alt="Image_valid" width="800" height="400" />
<img src="https://github.com/kuldeepsingh0330/sudoku_endpoint_springboot/assets/95225751/2e743549-a8d0-4540-a97c-3caba48ab49b" alt="Image_invalid" width="800" height="400" />
<img src="![suggestion](https://github.com/kuldeepsingh0330/sudoku_endpoint_springboot/assets/95225751/50de7b5f-e62f-4082-ad1f-7901e5a01ebf)" alt="Image_suggestion" width="800" height="400" />


## Contributing

Contributions are welcome! If you have any ideas, suggestions, or bug fixes, please open an issue or submit a pull request.



