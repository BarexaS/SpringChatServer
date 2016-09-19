package ua.kiev.prog;

public interface UserService {
    CustomUser getUserByLogin(String login);
    void addUser(CustomUser customUser);
}
