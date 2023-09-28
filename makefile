Store.class: Store.java admin.class user.class
							javac -g Store.java

admin.class: admin.java

							javac -g admin.java
user.class: user.java

							javac -g user.java
furniture.class: furniture.java

							javac -g furniture.java
chair.class: chair.java

							javac -g chair.java

sofa.class: sofa.java
							javac -g sofa.java

table.class: table.java
							javac -g table.java

ordered.class: ordered.java
							javac -g ordered.java

clean:
							rm -rf *.class
							rm -rf DATA.txt

run: Store.class
							java Store
