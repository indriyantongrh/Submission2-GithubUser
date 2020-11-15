#json_serializable

Provides Dart Build System builders for handling JSON.

The builders generate code when they find members annotated with classes defined in package:json_annotation.

To generate to/from JSON code for a class, annotate it with @JsonSerializable. You can provide arguments to JsonSerializable to configure the generated code. You can also customize individual fields by annotating them with @JsonKey and providing custom arguments. See the table below for details on the annotation values.

To generate a Dart field with the contents of a file containing JSON, use the JsonLiteral annotation.

To configure your project for the latest released version of, json_serializable see the example.

Add this to your package's pubspec.yaml file:

````
dependencies:
  json_serializable:
````
2. Install it
You can install packages from the command line:

with Flutter:

````
$ flutter pub get
````

###Example #
Given a library example.dart with an Person class annotated with @JsonSerializable():
````
import 'package:json_annotation/json_annotation.dart';

part 'example.g.dart';

@JsonSerializable(nullable: false)
class Person {
  final String firstName;
  final String lastName;
  final DateTime dateOfBirth;
  Person({this.firstName, this.lastName, this.dateOfBirth});
  factory Person.fromJson(Map<String, dynamic> json) => _$PersonFromJson(json);
  Map<String, dynamic> toJson() => _$PersonToJson(this);
}
````
Building creates the corresponding part example.g.dart:
````
part of 'example.dart';

Person _$PersonFromJson(Map<String, dynamic> json) {
  return Person(
    firstName: json['firstName'] as String,
    lastName: json['lastName'] as String,
    dateOfBirth: DateTime.parse(json['dateOfBirth'] as String),
  );
}

Map<String, dynamic> _$PersonToJson(Person instance) => <String, dynamic>{
      'firstName': instance.firstName,
      'lastName': instance.lastName,
      'dateOfBirth': instance.dateOfBirth.toIso8601String(),
    };
````