package src.company;

import java.time.Instant;
import java.util.*;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Message message = new Message("HELLow", "Dave", "857342346");
        Message message2 = new Message("Darova, che po chem?", "Danya", "857342344");
        Message message3 = new Message("Hey, what's up?", "Mike", "857342344");
        Message message4 = new Message("Are you at home?", "Jake", "857342347");
        Message message5 = new Message("I DON'T KNOW WHAT TO SAY", "Unknown", "857342345");
        Message message6 = new Message("Huh, bye...", "John", "857342345");
        Message message7 = new Message("Check it out!", "Alex", "857342345");
        Message message8 = new Message("I can't get enough of this", "Mira", "857342346");
        Message message9 = new Message("That's a deal! ", "Jane", "857342344");
        Message message10 = new Message("Huh, bye...", "Brandon", "857342344");
        Message message11 = new Message("Huh, bye...", "Milton", "857342345");
        Message message12 = new Message("You won't do this, will you", "Crag", "857342347");
        Message message13 = new Message("You won't do this, will you", "Crag", "857342347");
        Message message14 = new Message("Huh, bye...", "John", "857342347");
        Message message15 = new Message("Oh, if I were you!", "Michael", "857342347");
        Message message16 = new Message("Are you sleeping?", "Shone", "857342346");

        Message message17 = new Message("Just a little bit...", "Joel", "857342348");

        CallLog log = new CallLog(Instant.now(), "857342345", true);
        CallLog log2 = new CallLog(Instant.now(), "857342346", true);
        CallLog log3 = new CallLog(Instant.now(), "857342344", false);
        CallLog log4 = new CallLog(Instant.now(), "857342347", false);
        CallLog log5 = new CallLog(Instant.now(), "857342345", true);
        CallLog log6 = new CallLog(Instant.now(), "857342346", false);
        CallLog log7 = new CallLog(Instant.now(), "857342347", true);
        CallLog log8 = new CallLog(Instant.now(), "857342347", false);
        CallLog log9 = new CallLog(Instant.now(), "857342346", true);
        CallLog log10 = new CallLog(Instant.now(), "857342346", false);
        CallLog log11 = new CallLog(Instant.now(), "857342347", false);
        CallLog log12 = new CallLog(Instant.now(), "857342345", true);
        CallLog log13 = new CallLog(Instant.now(), "857342344", false);
        CallLog log14 = new CallLog(Instant.now(), "857342347", true);

        CallLog log15 = new CallLog(Instant.now(), "857342349", true);

        Contact contact = new Contact("857342344", "Coursera");
        Contact contact2 = new Contact("857342345", "Google");
        Contact contact3 = new Contact("857342346", "Yandex");
        Contact contact4 = new Contact("857342347", "ZeroGravity");
        Contact contact5 = new Contact("857342346", "Disney");
        Contact contact6 = new Contact("857342347", "Roshen");
        Contact contact7 = new Contact("857342347", "Roshen");
        Contact contact8 = new Contact("857342347", "Roshen");

        Contact contact9 = new Contact("857342347", "Microsoft");

        List<Message> messages = new ArrayList<>();
        List<CallLog> logs = new ArrayList<>();
        List<Contact> contacts = new ArrayList<>();

        messages.add(message);
        messages.add(message2);
        messages.add(message3);
        messages.add(message4);
        messages.add(message5);
        messages.add(message6);
        messages.add(message7);
        messages.add(message8);
        messages.add(message9);
        messages.add(message10);
        messages.add(message11);
        messages.add(message12);
        messages.add(message13);
        messages.add(message14);
        messages.add(message15);
        messages.add(message16);

        logs.add(log);
        logs.add(log2);
        logs.add(log3);
        logs.add(log4);
        logs.add(log5);
        logs.add(log6);
        logs.add(log7);
        logs.add(log8);
        logs.add(log9);
        logs.add(log10);
        logs.add(log11);
        logs.add(log12);
        logs.add(log13);
        logs.add(log14);

        contacts.add(contact);
        contacts.add(contact2);
        contacts.add(contact3);
        contacts.add(contact4);
        contacts.add(contact5);
        contacts.add(contact6);
        contacts.add(contact7);
        contacts.add(contact8);

        Collection<Contact> foundNumbers = Contact.findContact(contacts, String.valueOf(857342345L));
        Collection<Message> foundStrings = Message.findMessage(messages, "HELLow");
        Collection<CallLog> foundDates = CallLog.findDate(logs, Instant.now().toString());

        Main.iterativeCollectionFinder(foundNumbers, foundStrings, foundDates);

        System.out.println("\n 4 ??????????????");
        HashSet<Message> uniqueMessages = new HashSet<>(messages);
        HashSet<CallLog> unique??allLogs = new HashSet<>(logs);
        HashSet<Contact> uniqueContacts = new HashSet<>(contacts);

        System.out.println("???????????? ?????????? ???????? ????????????????");
        iterativeCollectionFinder(contacts, messages, unique??allLogs);
        System.out.println("\n ???????????????????? ?????????????? \n");
        iterativeCollectionFinder(uniqueContacts, uniqueMessages, unique??allLogs);
        // ?????? ?????????????????? ???????? ???? ?? ???????????? ?????????????????? ?? ?????????????? ???????????? ?????????????? ?????????????? ?? ??????????????????, ????????????
        // ?? ?????????? ?? ?? ?????????????? ?????? ???? ???????????????? ?????? ????????????
        // System.out.println("?????????? ??????????????????? " + Main.isCallLogCollectionHasDuplicates(logs));
        // System.out.println("?????????? ??????????????????? x2 " + Main.isCallLogCollectionHasDuplicates(unique??allLogs));
        System.out.println("\n 5 ??????????????");
        Map<Contact, ArrayList<Message>> contactMessagesMap = groupMessagesByContact(uniqueContacts, uniqueMessages);
        displayContentsOfMap(contactMessagesMap);

        System.out.println("\n 6 ??????????????");
        Map<Contact, ArrayList<CallLog>> contactCallsMap = groupCallsByContact(uniqueContacts, unique??allLogs);
        displayContentsOfMap2(contactCallsMap);

        System.out.println("\n 7 ??????????????, ?????????? a");
        ArrayList<CallLog> contactCallLogs = findCallLogs(unique??allLogs, contact2);
        showCallLogCollection(contactCallLogs);
        // ?????????? b
        Pair<Contact, ArrayList<CallLog>> pair = new Pair<>(contact, findCallLogs(logs, contact));
        // ???????????? c ?? d
        ArrayList<Pair<Contact, ArrayList<CallLog>>> pairsWithCallLogs = findCallLogsForAllContactsVER1(uniqueContacts, unique??allLogs);
        // ?????????? e
        sortCallLogPairsDescending(pairsWithCallLogs);
        // ?????????? f
        displaySortedCallLogPairs(pairsWithCallLogs);

        System.out.println("\n 8 ??????????????");
        ArrayList<Pair<Contact, ArrayList<Message>>> pairsWithMessages = findMessagesForAllContactsVER1(uniqueContacts, uniqueMessages);
        sortMessagePairsDescending(pairsWithMessages);
        displaySortedMessagePairs(pairsWithMessages);

        // ?????? ?????? ???? ??????????????????????, ???? ???? ?????????????? ?????? ?????????? ?????? ?? ???? ??????????????????
        System.out.println("\n 9 ??????????????");
        ArrayList<Pair<Contact, ArrayList<CallLog>>> pairsWithCallLogs2 = findCallLogsForAllContactsVER2(uniqueContacts, unique??allLogs);
        ArrayList<Pair<Contact, ArrayList<Message>>> pairsWithMessages2 = findMessagesForAllContactsVER2(uniqueContacts, uniqueMessages);
        displaySortedCallLogPairs(pairsWithCallLogs2);
        displaySortedMessagePairs(pairsWithMessages2);
        HashSet<CallLog> filteredBySuccess = getCallLogsFilteredByText(unique??allLogs, log);
        HashSet<Contact> filteredByPhone = getContactsFilteredByText(uniqueContacts, contact);
        HashSet<Message> filteredByContents = getMessagesFilteredByText(uniqueMessages, message);
        showFilteredCollections(filteredByContents, filteredByPhone, filteredBySuccess);

        System.out.println("\n 10 ??????????????");
        Queue<Contact> contactsQueue = new PriorityQueue<>(uniqueContacts);
        System.out.println("?????? ???????????????????????? ???????????????? ?? ???????????????????????? ??????????????: " + contact9.getCompanyName());
        boolean isInsertFail = contactsQueue.offer(contact9);
        Contact deletedContact = contactsQueue.poll();
        System.out.println("?????????????????? ???????????? ?????????????? ????????????: " + isInsertFail + "\n" +
                "?????????????????? ??????????????: " + deletedContact.getCompanyName() + " ???????????????? ???????????? ?????????????? ???????????? ??????, \n" +
                "?????????????? ???????????????? ???? ???????????? ???? ???????????????? \"???????????? ????????????????, ???????????? ??????????????\"\n?? ?????? ???? ?????????????????????????? ??????????????" +
                " ?????????????? ?????????????????? ?? ?????????????? ???????????????? ???????????????????????? ?????? ???????????????????? ?????????????????????? ?????????????????? Set\n");
        for (int counter = 0; counter < contactsQueue.size(); counter++) {
            System.out.println("?????????????????? ?????????????? ?????? null: " + contactsQueue.poll().getCompanyName());
        }

        Deque<Message> messagesDeque = new ArrayDeque<>(uniqueMessages);
        System.out.println();
        System.out.println("?????????? ???????????? ?????????????? ?????????????????? ?? ?????????");
        System.out.println(messagesDeque.getFirst().getMessage());
        messagesDeque.addFirst(message17);
        System.out.println("?? ?????????????");
        System.out.println(messagesDeque.getFirst().getMessage());
        System.out.println("?????????????? ???????????? ?????????????? ????????, ?? \"????????????\": " + messagesDeque.pollFirst().getMessage());
        System.out.println("?????????? ?????????????????? ?????????? ?????????????? ???????????? ?? ????????");
        System.out.println(messagesDeque.getFirst().getMessage());

        Deque<CallLog> callLogsDeque = new ArrayDeque<>(unique??allLogs);
        callLogsDeque.forEach(calllog -> System.out.println(calllog.getPhoneNumber()));
        System.out.println("???????????????????? ???????????? ?????????????? ?? ????????: " + callLogsDeque.peek().getPhoneNumber());
        System.out.println("?????????????????? ?????????? ?????????????? ?? ??????????: " + callLogsDeque.add(log15));
        callLogsDeque.forEach(calllog -> System.out.println(calllog.getPhoneNumber()));
        System.out.println("?????????????? ?????????? ?????????????? ???? ??????????????: " + callLogsDeque.pollLast().getPhoneNumber());
        callLogsDeque.forEach(calllog -> System.out.println(calllog.getPhoneNumber()));
        System.out.println("?????????? ???????????????????? ???????????? ?????????????? ?? ????????: " + callLogsDeque.peek().getPhoneNumber());
    }

    public static void displaySortedCallLogPairs(ArrayList<Pair<Contact, ArrayList<CallLog>>> pairs) {
        var count = 0;
        for (int counter = 0; counter < 5; counter++) {
            System.out.println("???????????????????? ?????????????? ?? ???????? ?????????? ???" + ++count + ": " + pairs.get(counter).getRight().size());
        }
    }

    public static void displaySortedMessagePairs(ArrayList<Pair<Contact, ArrayList<Message>>> pairs) {
        var count = 0;
        for (int counter = 0; counter < 5; counter++) {
            System.out.println("???????????????????? ?????????????????? ?? ???????? ?????????? ???" + ++count + ": " + pairs.get(counter).getRight().size());
        }
    }

    public static void iterativeCollectionFinder(Collection<Contact> contactCollection,
                                                 Collection<Message> messageCollection,
                                                 Collection<CallLog> callLogCollection) {
        callLogCollection.forEach(callLog -> System.out.println("callLog = " + callLog.getDate().toString()));
        contactCollection.forEach(contact -> System.out.println("contact = " + contact.getPhoneNumber()));
        messageCollection.forEach(message -> System.out.println("message = " + message.getMessage()));
    }

    public static HashSet<Message> getMessagesFilteredByText(HashSet<Message> messages, Message inputMessage) {
        Predicate<Message> messagePredicate = message -> message.getMessage().length() > 15;
        HashSet<Message> messageHashSet = new HashSet<>();
        for (Message message : messages) {
            if (messagePredicate.test(message)) {
                messageHashSet.add(message);
            }
        }
        return messageHashSet;
    }

    public static HashSet<Contact> getContactsFilteredByText(HashSet<Contact> contacts, Contact inputContact) {
        Predicate<Contact> messagePredicate = contact -> !contact.getPhoneNumber().equals(inputContact.getPhoneNumber());
        HashSet<Contact> contactHashSet = new HashSet<>();
        for (Contact contact : contacts) {
            if (messagePredicate.test(contact)) {
                contactHashSet.add(contact);
            }
        }
        return contactHashSet;
    }

    public static HashSet<CallLog> getCallLogsFilteredByText(HashSet<CallLog> callLogs, CallLog inputCallLog) {
        Predicate<CallLog> messagePredicate = callLog -> callLog.isSuccessfulCall() == inputCallLog.isSuccessfulCall();
        HashSet<CallLog> messageHashSet = new HashSet<>();
        for (CallLog callLog : callLogs) {
            if (messagePredicate.test(callLog)) {
                messageHashSet.add(callLog);
            }
        }
        return messageHashSet;
    }

    public static Map<Contact, ArrayList<CallLog>> groupCallsByContact(HashSet<Contact> contacts, HashSet<CallLog> callLogs) {
        Map<Contact, ArrayList<CallLog>> contactMessagesMap = new HashMap<>();
        for (Contact contact : contacts) {
            contactMessagesMap.put(contact, new ArrayList<>());
            for (CallLog callLog : callLogs) {
                if (contact.getPhoneNumber().equals(callLog.getPhoneNumber())) {
                    contactMessagesMap.get(contact).add(callLog);
                }
            }
        }
        return contactMessagesMap;
    }


    public static ArrayList<Pair<Contact, ArrayList<CallLog>>> findCallLogsForAllContactsVER1(Collection<Contact> contacts,
                                                                                              Collection<CallLog> callLogs) {
        ArrayList<Pair<Contact, ArrayList<CallLog>>> pairs = new ArrayList<>();
        for (Contact contact : contacts) {
            Pair<Contact, ArrayList<CallLog>> pair;
            pair = new Pair<>(contact, new ArrayList<>());
            for (CallLog callLog : callLogs) {
                if (contact.getPhoneNumber().equals(callLog.getPhoneNumber())) {
                    pair.getRight().add(callLog);
                }
            }
            pairs.add(pair);
        }
        return pairs;
    }

    public static ArrayList<Pair<Contact, ArrayList<CallLog>>> findCallLogsForAllContactsVER2(Collection<Contact> contacts,
                                                                                              Collection<CallLog> callLogs) {
        ArrayList<Pair<Contact, ArrayList<CallLog>>> pairs = new ArrayList<>();
        for (Contact contact : contacts) {
            pairs.add(findCallLogsForContact(contact, callLogs));
        }
        return pairs;
    }

    public static Pair<Contact, ArrayList<CallLog>> findCallLogsForContact(Contact contact,
                                                                           Collection<CallLog> callLogs) {
        Pair<Contact, ArrayList<CallLog>> pair = new Pair<>(contact, new ArrayList<>());
        Predicate<CallLog> messagePredicate = callLog -> callLog.getPhoneNumber().equals(contact.getPhoneNumber());
        for (CallLog callLog : callLogs) {
            if (messagePredicate.test(callLog)) {
                pair.getRight().add(callLog);
            }
        }
        return pair;
    }

    private static void swapCallLogPair(ArrayList<Pair<Contact, ArrayList<CallLog>>> pairs, int one, int two) {
        Pair<Contact, ArrayList<CallLog>> pair = pairs.get(one);
        pairs.add(one, pairs.get(two));
        pairs.add(two, pair);
    }

    public static ArrayList<Pair<Contact, ArrayList<Message>>> findMessagesForAllContactsVER1(Collection<Contact> contacts,
                                                                                              Collection<Message> messages) {
        ArrayList<Pair<Contact, ArrayList<Message>>> pairs = new ArrayList<>();
        for (Contact contact : contacts) {
            Pair<Contact, ArrayList<Message>> pair;
            pair = new Pair<>(contact, new ArrayList<>());
            for (Message message : messages) {
                if (contact.getPhoneNumber().equals(message.getPhoneNumber())) {
                    pair.getRight().add(message);
                }
            }
            pairs.add(pair);
        }
        return pairs;
    }

    public static ArrayList<Pair<Contact, ArrayList<Message>>> findMessagesForAllContactsVER2(Collection<Contact> contacts,
                                                                                              Collection<Message> messages) {
        ArrayList<Pair<Contact, ArrayList<Message>>> pairs = new ArrayList<>();
        for (Contact contact : contacts) {
            pairs.add(findMessagesForContact(contact, messages));
        }
        return pairs;
    }

    public static Pair<Contact, ArrayList<Message>> findMessagesForContact(Contact contact,
                                                                           Collection<Message> messages) {
        Pair<Contact, ArrayList<Message>> pair = new Pair<>(contact, new ArrayList<>());
        Predicate<Message> messagePredicate = message -> message.getPhoneNumber().equals(contact.getPhoneNumber());
            for (Message message : messages) {
                if (messagePredicate.test(message)) {
                    pair.getRight().add(message);
                }
            }
        return pair;
    }

    private static void swapMessagePair(ArrayList<Pair<Contact, ArrayList<Message>>> pairs, int one, int two) {
        Pair<Contact, ArrayList<Message>> pair = pairs.get(one);
        pairs.add(one, pairs.get(two));
        pairs.add(two, pair);
    }

    public static ArrayList<CallLog> findCallLogs(Collection<CallLog> callLogs, Contact contact) {
        ArrayList<CallLog> resultLogs = new ArrayList<>();

        for (CallLog callLog : callLogs) {
            if (callLog.getPhoneNumber().equals(contact.getPhoneNumber())) {
                resultLogs.add(callLog);
            }
        }
        return resultLogs;
    }

    public static ArrayList<Pair<Contact, ArrayList<CallLog>>> sortCallLogPairsDescending(ArrayList<Pair<Contact,
            ArrayList<CallLog>>> pairs) {
        for (int outer = pairs.size() - 1; outer > 1; outer--) {
            for (int inner = 0; inner < outer; inner++) {
                if (pairs.get(inner).getRight().size() < pairs.get(inner + 1).getRight().size()) {
                    swapCallLogPair(pairs, inner, inner + 1);
                }
            }
        }
        return pairs;
    }

    public static ArrayList<Pair<Contact, ArrayList<Message>>> sortMessagePairsDescending(ArrayList<Pair<Contact,
            ArrayList<Message>>> pairs) {
        for (int outer = pairs.size() - 1; outer > 1; outer--) {
            for (int inner = 0; inner < outer; inner++) {
                if (pairs.get(inner).getRight().size() < pairs.get(inner + 1).getRight().size()) {
                    swapMessagePair(pairs, inner, inner + 1);
                }
            }
        }
        return pairs;
    }

    public static Map<Contact, ArrayList<Message>> groupMessagesByContact(HashSet<Contact> contacts,
                                                                          HashSet<Message> messages) {
        Map<Contact, ArrayList<Message>> contactMessagesMap = new HashMap<>();
        for (Contact contact : contacts) {
            contactMessagesMap.put(contact, new ArrayList<>());
            for (Message message : messages) {
                if (contact.getPhoneNumber().equals(message.getPhoneNumber())) {
                    contactMessagesMap.get(contact).add(message);
                }
            }
        }
        return contactMessagesMap;
    }

    public static void displayContentsOfMap2(Map<Contact, ArrayList<CallLog>> groupedCallLogs) {
        for (var contact : groupedCallLogs.keySet()) {
            System.out.println("Contact name: " + contact.getCompanyName() + "\n" +
                    "Phone number: " + contact.getPhoneNumber());
            for (CallLog callLog : groupedCallLogs.get(contact)) {
                System.out.println("Phone number of a call: " + callLog.getPhoneNumber() + "\n" +
                        "Is successful call: " + callLog.isSuccessfulCall() + "\n" +
                        "Call date: " + callLog.getDate());
            }
            System.out.println("\n Next contact\n");
        }
        System.out.println("\n End of the list");
    }

    public static void displayContentsOfMap(Map<Contact, ArrayList<Message>> groupedMessages) {
        for (var contact : groupedMessages.keySet()) {
            System.out.println("Contact name: " + contact.getCompanyName() + "\n" +
                    "Phone number: " + contact.getPhoneNumber());
            for (Message message : groupedMessages.get(contact)) {
                System.out.println("Phone number from which was sent the message: " + message.getPhoneNumber() + "\n" +
                        "Message related to the contact: " + message.getMessage());
            }
            System.out.println("\n Next contact\n");
        }
        System.out.println("\n End of the list");
    }

    public static boolean isCallLogCollectionHasDuplicates(Collection<CallLog> collection) {
        HashSet<CallLog> collection2 = new HashSet<>(collection);
        var counter = 0;
        for (CallLog callLog : collection) {
            for (CallLog callLog2 : collection2) {
                if (callLog.equals(callLog2)) {
                    ++counter;
                    if (counter > 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void showCallLogCollection(Collection<CallLog> collection) {
        for (CallLog callLog : collection) {
            System.out.println("Phone number of a call: " + callLog.getPhoneNumber() + "\n" +
                    "Is successful call: " + callLog.isSuccessfulCall() + "\n" +
                    "Call date: " + callLog.getDate());
            System.out.println();
        }
    }

    public static void showFilteredCollections(HashSet<Message> messages,
                                               HashSet<Contact> contacts,
                                               HashSet<CallLog> callLogs) {
        for (Message message : messages) {
            System.out.println(message.getMessage());
        }
        for (Contact contact : contacts) {
            System.out.println(contact.getPhoneNumber());
        }
        for (CallLog callLog : callLogs) {
            System.out.println(callLog.isSuccessfulCall());
        }
    }
}
