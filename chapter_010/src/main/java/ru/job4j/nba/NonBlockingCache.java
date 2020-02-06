package ru.job4j.nba;

import java.util.concurrent.ConcurrentHashMap;

class NonBlockingCache {
    private final ConcurrentHashMap<Integer, Base> store;

    NonBlockingCache() {
        store = new ConcurrentHashMap<>();
    }

    void add(Base model) {
        store.putIfAbsent(model.getId(), model);
    }

    void update(Base model) throws OptimisticException {
        store.computeIfPresent(model.getId(),
                (key, value) -> {
                    int version = model.getVersion();
                    if (version != value.getVersion()) {
                        throw new OptimisticException("Data can't be changed.");
                    }
                    version++;
                    model.setVersion(version);
                    return model;
                }
        );
    }

    Base delete(Base model) {
        return store.remove(model.getId());
    }

    Base getModel(int id) {
        Base model = store.get(id);
        return new Base(model.getId(), model.getName(), model.getVersion());
    }
}
