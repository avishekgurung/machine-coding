package org.avishek.gateway;

public class Driver {
    public static void main(String[] args) {
        /**
         * DI injection
         */
        Trie trie = new Trie();
        Repo repo = new Repo();
        Registration registration = new Registration(repo, trie);
        Resolver resolver = new Resolver(repo, trie);

        String gateway1 = "mathew/mark/luke";
        String gateway2 = "mathew/mark/john";
        String gateway3 = "mathew/samuel/john";
        String gateway4 = "mathew/samuel";

        String gateway5 = "mathew/samuel/john/william";
        String gateway6 = "mathew/rick/dan/william";
        String gateway7 = "mathew/paul/jim/william";

        registration.register(gateway1);
        registration.register(gateway2);
        registration.register(gateway3);
        registration.register(gateway4);
        registration.register(gateway5);
        registration.register(gateway6);
        registration.register(gateway7);
        System.out.println("");

        resolver.resolve(gateway1);
        resolver.resolve("mathew/mark/*");
        resolver.resolve("mathew/*");
        resolver.resolve("mathew/*/*/william");
    }
}
