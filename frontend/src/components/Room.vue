<template>
  <v-container>
    <ul>
      <li v-for="room in rooms" :key="room.roomId">
        <p>{{ room.roomId }}</p>
        <p>{{ room.roomType }}</p>
        <p>{{ room.roomName }}</p>
        <p>{{ room.enterCode }}</p>
        <p>{{ room.available }}</p>
      </li>
    </ul>
  </v-container>
</template>

<script>
import axios from 'axios'

export default {
  data () {
    return { rooms: [{
      roomId: '',
      roomType: '',
      roomName: '',
      enterCode: '',
      available: false
    }]
  }},
  mounted () {
    axios.get('/api/room/all')
        .then(response => {
          this.rooms = response.data
        })
        .catch(error => {
          console.log(error)
        })
  }
}
</script>
