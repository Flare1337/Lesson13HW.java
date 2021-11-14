package src.company;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class CallLog implements Comparable<CallLog> {
    private Instant date;
    private long phoneNumber;
    private boolean isSuccessfulCall;

    public CallLog(Instant date, long phoneNumber, boolean isSuccessfulCall) {
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.isSuccessfulCall = isSuccessfulCall;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSuccessfulCall() {
        return isSuccessfulCall;
    }

    public void setSuccessfulCall(boolean successfulCall) {
        isSuccessfulCall = successfulCall;
    }

    public static Collection<CallLog> findDate(Collection<CallLog> dateCollection, String inputDate) {
        Collection<CallLog> callLogs = new ArrayList<>();
        for (CallLog log : dateCollection) {
            if (log.getDate().toString().equals(inputDate)) {
                callLogs.add(log);
            }
        }
        return callLogs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CallLog callLog = (CallLog) o;
        return phoneNumber == callLog.phoneNumber &&
                isSuccessfulCall == callLog.isSuccessfulCall &&
                date.equals(callLog.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, phoneNumber);
    }

    @Override
    public int compareTo(CallLog o) {
        return 0;
    }
}
