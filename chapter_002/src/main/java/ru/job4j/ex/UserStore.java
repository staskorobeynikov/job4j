package ru.job4j.ex;

public class UserStore {
    public User findUser(User[] users, String login) throws UserNotFoundException {
        User result = null;
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                result = user;
                break;
            }
        }
        if (result == null) {
            throw new UserNotFoundException("User not found.");
        }
        return result;
    }

    public boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException("User is not valid.");
        }
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("Username length is less 3.");
        }
        return true;
    }

    public static void main(String[] args) {
        UserStore userStore = new UserStore();
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = userStore.findUser(users, "Petr Arsentev");
            if (userStore.validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException uie) {
            uie.printStackTrace();
        } catch (UserNotFoundException unfe) {
            unfe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
