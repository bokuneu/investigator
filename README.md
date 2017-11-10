1. The complexity of the code is O(n2).
2. The algorithm is suitable for vertical scale. It does not scale horizontally as it runs in a single thread.
    If I had more time for this task, I would run inner loop of groupSentences() method in a new thread (roughly saying),
    so that it could search groups for sentences in parallel and would be able to scale horizontally in
    multiprocessor/multicore environment.
3. The current implementation rely on correct input and does not do any validation for development time-saving reasons.