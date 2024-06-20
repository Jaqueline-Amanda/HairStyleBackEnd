package br.com.hairstyle.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class HairdresserDto {

    private int id;

    private String name;

    private String address;

    private String telephone;


    public String getFullName(){
        return this.name + " - " + this.telephone;
    }

}
