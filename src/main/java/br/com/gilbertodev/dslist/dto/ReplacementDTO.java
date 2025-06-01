package br.com.gilbertodev.dslist.dto;

import java.util.Objects;

/**
 * Data Transfer Object (DTO) used to represent the movement of an element within a list.
 *
 * <p>Typically used to specify the source and destination indices when reordering
 * games in a game list.</p>
 *
 * @author Gilberto Dev
 */
public class ReplacementDTO {

    /**
     * The index from which the item is being moved.
     */
    private Integer sourceIndex;

    /**
     * The index to which the item is being moved.
     */
    private Integer destinationIndex;

    /**
     * Returns the source index of the item to be moved.
     *
     * @return the original index
     */
    public Integer getSourceIndex() {
        return sourceIndex;
    }

    /**
     * Sets the source index of the item to be moved.
     *
     * @param sourceIndex the original index
     */
    public void setSourceIndex(Integer sourceIndex) {
        this.sourceIndex = sourceIndex;
    }

    /**
     * Returns the destination index of the item to be moved.
     *
     * @return the target index
     */
    public Integer getDestinationIndex() {
        return destinationIndex;
    }

    /**
     * Sets the destination index of the item to be moved.
     *
     * @param destinationIndex the target index
     */
    public void setDestinationIndex(Integer destinationIndex) {
        this.destinationIndex = destinationIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReplacementDTO that)) return false;
        return Objects.equals(sourceIndex, that.sourceIndex) &&
               Objects.equals(destinationIndex, that.destinationIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceIndex, destinationIndex);
    }

    @Override
    public String toString() {
        return "ReplacementDTO{" +
               "sourceIndex=" + sourceIndex +
               ", destinationIndex=" + destinationIndex +
               '}';
    }
}
