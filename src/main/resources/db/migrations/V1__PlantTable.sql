
CREATE TABLE plant (
    id UUID NOT NULL PRIMARY KEY,
    userId VARCHAR(100) NOT NULL,
    commonname VARCHAR(100) NOT NULL,
    scientificname VARCHAR(100) NOT NULL,
    familycommonname VARCHAR(100) NOT NULL,
    family VARCHAR(100) NOT NULL,
    genus VARCHAR(100) NOT NULL,
    year INT,
    genus VARCHAR(100),
    UNIQUE (scientificname)
)






    private final UUID id;
    private final String userId;
    private final String commonName;

    // @Column(unique=true)
    private final String scientificName;

    private final String familyCommonName;
    private final String family;
    private final String genus;
    private final int year;
    private final String imageUrl;





