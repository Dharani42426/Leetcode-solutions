📒 HASHMAP IN JAVA — DSA NOTES
1. What is HashMap?

HashMap is a Java data structure that stores information in key-value pairs.

HashMap<Key, Value> map = new HashMap<>();

Example:

HashMap<Integer, String> map = new HashMap<>();

map.put(101, "Dharani");
map.put(102, "Rahul");

Conceptually:

Key       Value
101   →   Dharani
102   →   Rahul
The main idea

HashMap is fast memory for information that I may need to look up later.

Instead of repeatedly searching through an array, we store information so that we can retrieve it quickly.

2. Why does HashMap exist?

Suppose:

[10, 25, 7, 31, 18, 42]

You want to know:

"Have I already seen 31?"

With an array, you may have to search:

10 → 25 → 7 → 31

That can take O(n).

With a HashMap/HashSet, we can store what we've already seen and perform an expected O(1) lookup.

The DSA trigger 🚨

Whenever you think:

"I need to repeatedly search for something I've already seen."

Think:

HashMap / HashSet

3. The MOST important HashMap idea

Don't start by asking:

❌ "Which HashMap method should I use?"

Instead ask:

✅ "What information do I need to find quickly?"

Then:

What do I look up?
       ↓
      KEY

What do I need to know about it?
       ↓
     VALUE
⭐ Formula to remember

What do I need to find quickly? → KEY
What do I need to know about it? → VALUE

This is the heart of HashMap problem solving.

4. Key and Value

Example:

map.put(10, 50);

Here:

Key   = 10
Value = 50

The key identifies something.

The value stores information about that key.

Examples:

number → frequency
number → index
student ID → student
character → frequency
prefix sum → frequency
5. How does HashMap work?

You don't need to know every internal implementation detail for DSA, but understand the basic idea.

Conceptually:

Key
 ↓
hashCode()
 ↓
hash processing
 ↓
bucket
 ↓
find matching key
 ↓
value

HashMap internally has buckets.

For example:

Bucket 0
Bucket 1
Bucket 2
Bucket 3
...

A key is processed to determine where its entry should be stored.

6. Hashing

A hash function converts a key into a hash value.

Conceptually:

Key
 ↓
Hash Function
 ↓
Hash Value
 ↓
Bucket

In Java, objects provide a hashCode() method.

Example conceptually:

"apple".hashCode()

produces an integer.

HashMap uses that information to determine where the key belongs.

7. Collision

Sometimes two different keys end up in the same bucket.

This is called a collision.

Example:

42 → Bucket 2
52 → Bucket 2

Even though:

42 != 52

they may end up in the same bucket.

Important!

Same hash ≠ same key

HashMap uses equals() to determine whether the keys are actually equal.

Conceptually:

hashCode()
    ↓
Which bucket?
    ↓
equals()
    ↓
Is this actually the same key?
8. equals() and hashCode()

Important rule:

If two objects are equal according to equals(), they must have the same hashCode().

But:

Two different objects can have the same hash code.

So:

equals() = true
      ↓
hashCode() must be same

But:

hashCode() same
      ↓
does NOT mean
      ↓
equals() = true

For DSA, understand the rule. You don't need to dive deeply into custom objects yet.

9. Basic HashMap operations
Creating
HashMap<Integer, Integer> map = new HashMap<>();
put()

Adds a key-value pair.

map.put(10, 100);

Means:

10 → 100
Updating

If the key already exists:

map.put(10, 200);

Now:

10 → 200

It doesn't create another 10 key.

10. get()

Used to retrieve a value.

map.get(10);

If:

10 → 200

then:

map.get(10)

returns:

200

If the key doesn't exist, get() normally returns null.

11. containsKey()

Checks whether a key exists.

map.containsKey(10);

Returns:

true / false

Use this when your actual question is:

"Does this key exist?"

12. getOrDefault() ⭐

Extremely important for DSA.

map.getOrDefault(key, 0);

Means:

If key exists → give me its value.
If it doesn't exist → give me 0.

Example:

map.put(x, map.getOrDefault(x, 0) + 1);

This is the standard frequency-counting pattern.

13. remove()

Removes a key-value pair.

map.remove(10);
14. Iterating through HashMap
Keys
for (Integer key : map.keySet()) {
    System.out.println(key);
}
Values
for (Integer value : map.values()) {
    System.out.println(value);
}
Key + Value ⭐
for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    int key = entry.getKey();
    int value = entry.getValue();
}

For DSA, entrySet() is important.

15. Important methods to know

Don't memorize every HashMap method.

Master these first:
put()
get()
containsKey()
getOrDefault()
remove()
entrySet()

Later:

putIfAbsent()
computeIfAbsent()
keySet()
values()
16. Time Complexity
Operation	Expected
put()	O(1)
get()	O(1)
containsKey()	O(1)
remove()	O(1)
containsValue()	O(n)
Important wording

Don't say:

"HashMap is always O(1)."

Say:

HashMap provides expected O(1) basic operations under normal/good hashing conditions.

17. Why is containsValue() O(n)?

HashMap is organized around keys.

If you ask:

map.containsKey(10);

HashMap knows where to look.

But if you ask:

map.containsValue(100);

there isn't a direct bucket based on the value.

It may need to inspect many entries.

Therefore:

containsKey → expected O(1)
containsValue → O(n)
🧠 18. The DSA Mental Model

This is the section you should remember the most.

Whenever you see a problem, ask:

Step 1

What do I need to look up?

That becomes the KEY.

Step 2

What information do I need about it?

That becomes the VALUE.

Step 3

Process the input:

Current element
      ↓
Calculate what I need
      ↓
HashMap lookup
      ↓
Use stored information
      ↓
Update HashMap
19. Pattern 1 — Frequency Counting ⭐

Suppose:

[2, 3, 2, 5, 3, 2]

We want:

2 → 3
3 → 2
5 → 1

Ask:

What am I looking up?

Number

Therefore:

KEY = number

What do I need to know?

Frequency

Therefore:

VALUE = frequency
Pattern
number → frequency
Code
HashMap<Integer, Integer> freq = new HashMap<>();

for (int x : nums) {
    freq.put(x, freq.getOrDefault(x, 0) + 1);
}
Recognition clues

Words such as:

frequency
count
occurrences
appearances
most frequent
least frequent
duplicate count

should make you consider frequency counting.

20. Pattern 2 — Duplicate / Seen Before

Example:

[4, 7, 2, 7, 9]

Question:

Is anything repeated?

What do we need?

Have I seen x?

We don't need additional information.

Therefore:

Prefer HashSet
HashSet
    ↓
Does x exist?

Whereas:

HashMap
    ↓
What information do I have about x?
Important lesson

Not every problem that involves HashMap thinking actually needs HashMap.

21. Pattern 3 — Value → Index ⭐

Example:

[5, 2, 8, 2, 9]

If we need to know where a number appeared:

5 → 0
2 → 1
8 → 2
9 → 4

Then:

KEY = value
VALUE = index

Pattern:

value → index

Recognition clues:

where did I see this?
first occurrence
last occurrence
position
index
earliest/latest position
22. Pattern 4 — Two Sum ⭐⭐⭐

Example:

nums = [2, 7, 11, 15]
target = 9

For current number:

x = 7

We calculate:

needed = target - x
needed = 9 - 7
needed = 2

Then ask:

Have I already seen 2?

That's a fast lookup.

Store:

number → index

So:

KEY = number
VALUE = index
Mental pattern
current
   ↓
needed = target - current
   ↓
lookup needed
   ↓
found?
23. Pattern 5 — Character Frequency

Example:

"banana"

Frequency:

b → 1
a → 3
n → 2

Therefore:

character → frequency

But remember:

If the problem guarantees only lowercase English letters:

int[] freq = new int[26];

may be better.

Important DSA lesson

Don't use HashMap just because you know HashMap.

Choose the simplest suitable data structure.

24. Pattern 6 — First/Last Occurrence

Suppose:

[5, 2, 8, 2, 9]

First occurrence:

5 → 0
2 → 1
8 → 2
9 → 4

Last occurrence:

5 → 0
2 → 3
8 → 2
9 → 4

Pattern:

value → index

The difference is which index you choose to store.

25. Pattern 7 — Sliding Window + HashMap ⭐⭐⭐

Example:

Longest Substring Without Repeating Characters

abcabcbb

We need to know:

When did I last see this character?

Therefore:

character → latest index

Here:

Sliding Window = WHERE am I looking?

HashMap = WHAT information have I remembered?

This distinction is extremely useful.

26. Pattern 8 — Prefix Sum + HashMap ⭐⭐⭐

This is one of the most important advanced beginner/intermediate patterns.

Suppose we need:

Number of subarrays whose sum equals K.

Let current prefix sum be:

S

We need some previous prefix:

P

such that:

S - P = K

Therefore:

P = S - K

Now the question becomes:

Have I seen prefix sum S - K before?

That's a HashMap lookup.

Store:

prefix sum → frequency
Mental transformation

Instead of:

Find all possible subarrays

we transform it into:

Current prefix
      ↓
What previous prefix do I need?
      ↓
S - K
      ↓
HashMap lookup

This can reduce an O(n²) approach to expected O(n).

27. Pattern 9 — Grouping

Suppose:

A → CSE
B → ECE
C → CSE
D → EEE

We want:

CSE → [A, C]
ECE → [B]
EEE → [D]

Pattern:

group → collection of members

Possible structure:

HashMap<String, ArrayList<String>>

General idea:

Computed category/signature → group

28. Pattern 10 — Mapping

Examples:

student ID → student information
product ID → price
username → user
character → replacement

General pattern:

identifier → information

Ask:

What uniquely identifies the information I want?

That becomes the key.

29. Pattern 11 — String Mapping

Example:

egg
add

We can map:

e → a
g → d

But we must also ensure:

a → e
d → g

This is why some mapping problems require:

Map 1
+
Map 2

or:

Map + Set

The important concept:

HashMap can represent relationships, not just frequencies.

30. HashMap is NOT the algorithm

This is very important.

For example:

Two Sum
Complement lookup
        +
     HashMap
Subarray Sum Equals K
Prefix Sum
      +
   HashMap
Longest Substring Without Repeating
Sliding Window
      +
   HashMap

So don't think:

"This is a HashMap algorithm."

Instead think:

"What algorithmic pattern am I using, and what information does HashMap help me remember?"

31. When should I think about HashMap?

Ask these questions:

Question 1

Am I repeatedly searching for something I've already processed?

Yes → Consider HashMap/HashSet

Question 2

Do I need to associate one thing with information about another?

Yes → Consider HashMap

Question 3

Does the problem involve frequency?

Consider HashMap

Question 4

Does it ask "Have I seen this before?"

Consider HashSet first.

Question 5

Can I calculate something I need from the current element?

For example:

needed = target - current

Then ask:

Can I quickly look up needed?

HashMap may be useful.

32. HashMap Decision Tree ⭐
Do I need to remember information
about something I've already processed?
              |
         NO → Probably not HashMap
              |
             YES
              ↓
Do I only need to know whether it exists?
              |
        YES → HashSet
              |
             NO
              ↓
Do I need information/count/index/etc.?
              |
            YES
              ↓
           HashMap

Then ask:

What am I looking up?
        ↓
      KEY

What do I need to know?
        ↓
      VALUE
33. HashMap vs HashSet
HashSet

Use when:

I only care whether something exists.

x → exists?
HashMap

Use when:

I need information associated with x.

x → information
Example

"Does 5 appear?"

→ HashSet

"How many times does 5 appear?"

→ HashMap

"Where did I first see 5?"

→ HashMap

34. HashMap vs Array
Array

Good when:

keys are small/bounded integers
direct index access is useful
fixed range

Example:

0–100

You could use:

int[] freq = new int[101];
HashMap

Better when:

keys can be arbitrary
keys aren't conveniently mapped to small indices
you need key → information
35. HashMap vs TreeMap
HashMap
Fast expected lookup
No ordering guarantee
TreeMap
Keys maintained in sorted order
O(log n) basic operations

If the problem says:

"Give keys in sorted order"

Think about TreeMap, not automatically HashMap.

36. HashMap vs LinkedHashMap
HashMap

Doesn't guarantee iteration order.

LinkedHashMap

Maintains insertion/encounter order.

So:

Need lookup + don't care about order
→ HashMap

Need lookup + insertion order
→ LinkedHashMap
37. When HashMap is unnecessary
Case 1 — Small bounded values
nums[i] ∈ [0, 100]

An array may be simpler.

Case 2 — Lowercase letters
'a'–'z'

Use:

int[26]

when appropriate.

Case 3 — Only existence

Use:

HashSet
Case 4 — Sorted keys

Consider:

TreeMap
Case 5 — Need order

Consider:

LinkedHashMap
38. Common mistakes 🚨
Mistake 1

Using:

map.get(x) != null

to mean "does key exist?"

Prefer:

map.containsKey(x)

when checking key existence.

Mistake 2

Using HashMap when HashSet is enough.

Mistake 3

Using HashMap when an array is simpler.

Mistake 4

Assuming HashMap preserves order.

It does not guarantee iteration order.

Mistake 5

Choosing the wrong key/value.

Always ask:

What will I look up?
→ KEY

What information do I need?
→ VALUE
Mistake 6

Thinking put() creates duplicate keys.

map.put(5, 10);
map.put(5, 20);

Result:

5 → 20
Mistake 7

Thinking HashMap is always O(1).

Correct:

Expected O(1) under normal/good hashing conditions.

39. The HashMap Smell 👃

While solving a problem, watch for this structure:

Process elements one by one.

For current element:
"I need information about something
I've already processed."

🚨 HashMap smell!

Ask:

Can I store that previous information in a HashMap?

If yes, determine:

KEY = what I need to find

VALUE = information I need about it
40. Brute Force → HashMap Transformation ⭐⭐⭐

This is one of the most important DSA ideas.

Brute force
Current element
      ↓
Search all previous elements
      ↓
O(n)

Repeated for n elements:

O(n²)
Optimized
Previous information
        ↓
      HashMap
        ↓
Current element
        ↓
Expected O(1) lookup

Overall:

O(n)

The HashMap isn't magic.

You're trading extra memory for faster lookup.

41. The Key-Value Design Rule

Before coding, literally write:

I will look up __________

Therefore:

KEY = __________

I need to know __________

Therefore:

VALUE = __________
Two Sum
I will look up → needed number

KEY = number

I need to know → index

VALUE = index
Frequency
I will look up → number

KEY = number

I need to know → frequency

VALUE = frequency
Sliding Window
I will look up → character

KEY = character

I need to know → latest index

VALUE = latest index
Prefix Sum
I will look up → previous prefix sum

KEY = prefix sum

I need to know → frequency/index

VALUE = frequency/index
42. DSA Learning Progression

Follow this order.

🟢 Level 1 — Basic HashMap

Learn:

put
get
containsKey
getOrDefault
remove
entrySet

Goal:

Write basic HashMap code without looking up syntax.

🟢 Level 2 — Frequency

Learn:

value → frequency

Problems involving:

counting
occurrences
duplicates
most frequent
🟢 Level 3 — Strings

Learn:

character → frequency
character → index
character → mapping

Practice:

Valid Anagram
First Unique Character
Isomorphic Strings
Group Anagrams
🟡 Level 4 — Arrays

Learn:

value → index
value → frequency
value → previous occurrence
🟡 Level 5 — Sliding Window + HashMap

Learn:

character → latest index
character → frequency

Understand:

Sliding Window tells you WHERE. HashMap remembers WHAT.

🔴 Level 6 — Prefix Sum + HashMap

Learn:

prefix sum → frequency
prefix sum → earliest index

Master:

Subarray Sum Equals K

🔴 Level 7 — Advanced combinations

Combine HashMap with:

sorting
sliding window
prefix sum
two pointers
sets
greedy
grouping
heaps
custom objects

At this stage, stop thinking:

"This is a HashMap problem."

Start thinking:

"What information must I remember so that my next operation becomes fast?"

43. Problems — Your Practice Order

Don't solve them randomly.

🟢 Level 1
Count Frequency of Elements
Most Frequent Element
🟢 Level 2
Contains Duplicate
First Unique Character
Valid Anagram
🟢 Level 3
Two Sum
Intersection of Two Arrays
🟡 Level 4
Isomorphic Strings
Group Anagrams
🟡 Level 5
Longest Substring Without Repeating Characters
Longest Substring with At Most K Distinct Characters
🔴 Level 6
Subarray Sum Equals K
Longest Subarray with Sum K
Subarray with Zero Sum
🔴 Level 7
Top K Frequent Elements
Longest Consecutive Sequence
Minimum Window Substring
🧠 44. Your HashMap Cheat Sheet

When you see a problem:

                HASHMAP
                   ↓
      Do I need previous information?
                   ↓
                  YES
                   ↓
       What do I need to look up?
                   ↓
                  KEY
                   ↓
      What information do I need?
                   ↓
                 VALUE

Common patterns:

How many?
→ value → frequency

Have I seen it?
→ HashSet

Where did I see it?
→ value → index

When did I last see it?
→ value → latest index

Find complement?
→ value → index/info

Subarray sum?
→ prefix sum → frequency/index

Sliding window?
→ character/value → frequency/index

Grouping?
→ signature/category → list
⭐ 45. The One Formula You Should Remember
WHAT DO I NEED TO FIND QUICKLY? → KEY
WHAT DO I NEED TO KNOW ABOUT IT? → VALUE

And the second formula:

Brute force = repeatedly search
HashMap = remember previous information
