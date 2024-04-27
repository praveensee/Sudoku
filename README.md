The repository consists of a Sudoku puzzle solver java file along with build and creating a docker image with dependencies. We use the maven jar plugin to build the executable jar and use docker configuration to create a docker image.

Below commands are used to build a docker image
sudo docker build -t sudoku-app .
sudo docker run -it -p 9876:9876 sudoku-app

