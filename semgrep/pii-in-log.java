class Fixture {
    void logs(String borrowerIdNo, String validNo, String rrn, Long loanId) {
        // ruleid: pii-in-log
        log.info("export borrower={}", borrowerIdNo);
        // ruleid: pii-in-log
        logger.debug("rrn " + rrn);
        // ok: pii-in-log
        log.info("export borrower={}", Masking.idNo(borrowerIdNo));
        // ruleid: pii-in-log
        log.info("{} {}", rrn, loanId.toString());
        // ok: pii-in-log
        log.info("valid={} loan={}", validNo, loanId);
    }
}
