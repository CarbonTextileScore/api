package fr.carbon.textile.score.api.database.entity.user_information;

public enum Role {
    USER("ROLE_USER"),
    CITY("ROLE_CITY"),
    COUNTRY("ROLE_COUNTRY");

    Role(String role) {
        _role = role;
    }

    private final String _role;

    @Override
    public String toString() {
        return _role;
    }
}
