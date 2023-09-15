package lk.ijse.carrent.layerd.repository;

import lk.ijse.carrent.layerd.repository.custom.impl.UserRepoImpl;

public class RepoFactory {
    private static RepoFactory repoFactory;
    private RepoFactory(){}

    public static RepoFactory getInstance(){

        return (repoFactory == null)? repoFactory = new RepoFactory():repoFactory;
    }

    public SuperRepo getRepo(RepoType type){
        switch (type){

            case USER:
                return new UserRepoImpl();

            default :
                return null;
        }
    }

    public enum RepoType{
        USER
    }


}
