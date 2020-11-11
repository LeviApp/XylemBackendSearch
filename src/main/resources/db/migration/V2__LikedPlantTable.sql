CREATE TABLE LIKEDPLANT (
  	id INTEGER AUTO_INCREMENT PRIMARY KEY,  
    user_id VARCHAR(100) NOT NULL,
    plant_id INTEGER NOT NULL,
    liked BOOLEAN NOT NULL,
    UNIQUE (user_id, plant_id)
);
