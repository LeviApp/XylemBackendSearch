
CREATE TABLE plant (
    id UUID NOT NULL PRIMARY KEY,
    userid VARCHAR(100) NOT NULL,
    commonname VARCHAR(100) NOT NULL,
    scientificname VARCHAR(100) NOT NULL,
    familycommonname VARCHAR(100) NOT NULL,
    family VARCHAR(100) NOT NULL,
    genus VARCHAR(100) NOT NULL,
    year INT,
    imageurl VARCHAR(255),
    UNIQUE (scientificname)
);


