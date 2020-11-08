
CREATE TABLE PLANT (
  	id INT AUTO_INCREMENT PRIMARY KEY,  
    user_id VARCHAR(100) NOT NULL,
    common_name VARCHAR(100) NOT NULL,
    scientific_name VARCHAR(100) NOT NULL,
    family_common_name VARCHAR(100) NOT NULL,
    family VARCHAR(100) NOT NULL,
    genus VARCHAR(100) NOT NULL,
    year INTEGER,
    image_url VARCHAR(255),
    UNIQUE (scientific_name)
);


