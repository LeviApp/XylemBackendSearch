CREATE TABLE RECOMMENDEDPLANT (
  	id INTEGER AUTO_INCREMENT PRIMARY KEY,  
    recommended_by VARCHAR(100) NOT NULL,
    recommended_to VARCHAR(100) NOT NULL,
    plant_id INTEGER NOT NULL,
    UNIQUE (recommended_by, recommended_to, plant_id),
    FOREIGN KEY (plant_id) REFERENCES PLANT(id) ON DELETE CASCADE
);
