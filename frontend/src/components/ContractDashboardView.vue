<template>
    <v-data-table
        :headers="headers"
        :items="items"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>
</template>

<script>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { VDataTable } from 'vuetify/labs/VDataTable'

export default {
    name: 'ContractDashboardView',
    components: {
        VDataTable,
    },
    props: {
        value: Object,
        editMode: Boolean,
        isNew: Boolean
    },
    setup() {
        const headers = ref([
            // 필드 디스크립터를 기반으로 헤더 설정
            { title: "id", key: "id" },
            { title: "title", key: "title" },
            { title: "name", key: "name" },
            { title: "contractStartAt", key: "contractStartAt" },
            { title: "contractEndAt", key: "contractEndAt" },
            { title: "houseName", key: "houseName" },
            { title: "houseLocation", key: "houseLocation" },
        ]);

        const items = ref([]);

        onMounted(async () => {
            try {
                const response = await axios.get('/contractDashboards');
                const data = response.data._embedded.contractDashboards;
                data.forEach(obj => {
                    obj.id = obj._links.self.href.split("/").pop();
                });
                items.value = data;
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        });

        return {
            headers,
            items
        };
    }
}
</script>
